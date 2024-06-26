package com.example.fanCommunity.controller;

import com.example.fanCommunity.dto.Post;
import com.example.fanCommunity.service.PostService;
import com.example.fanCommunity.util.PagingUtil;
import com.example.fanCommunity.util.PhotoUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    PagingUtil pagingUtil;

    @Autowired
    PhotoUtil photoUtil;

    @GetMapping(value = "/") // localhost/
    public String index() { return "index"; }

    @GetMapping(value = "/media") //localhost/media
    public String media() {
        return "post/media";
    }

    @GetMapping(value = "/view")
    public String view(HttpServletRequest request, Model model) {
        try {
            int postId = Integer.parseInt(request.getParameter("postId"));
            String pageNum = request.getParameter("pageNum");
            String searchKey = request.getParameter("searchKey");
            String searchValue = request.getParameter("searchValue");

            if (searchValue != null) {
                searchValue = URLDecoder.decode(searchValue, "UTF-8");
            }
            //조회수 늘리기
            postService.updateHitCount(postId);

            //게시물 데이터 가져오기
            Post post = postService.getReadPost(postId);

            //가져온 게시물이 없다면
            if (post == null) return  "redirect:/list?pageNum=" + pageNum;

            String param = "pageNum=" + pageNum;

            //검색어가 있다면
            if (searchValue != null && !searchValue.equals("")) {
                param += "&searchKey=" + searchKey;
                param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
            }
            model.addAttribute("post", post);
            model.addAttribute("params", param);
            model.addAttribute("pageNum", pageNum);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "post/view";
    }


    //localhost/list
    @RequestMapping(value = "/list",
                    method = {RequestMethod.GET, RequestMethod.POST})
    public String list(HttpSession session, HttpServletRequest request, Model model) {
        try {
            String pageNum = request.getParameter("pageNum");
            pagingUtil.setCurrentPage(1);
            if (pageNum != null) pagingUtil.setCurrentPage(Integer.parseInt(pageNum));

            int userId = (int) session.getAttribute("user_id");
            String searchKey = request.getParameter("searchKey"); //검색키워드
            String searchValue = request.getParameter("searchValue"); //검색어

            if (searchValue == null) {
                searchKey = "title"; // 검색 키워드의 디폴트는 title
                searchValue = ""; //검색어의 디폴트값은 빈문자열
            }  else {
                searchValue = URLDecoder.decode(searchValue, "UTF-8");
            }

            Map map = new HashMap();
            map.put("userId", userId);
            map.put("searchKey", searchKey);
            map.put("searchValue", searchValue);

            //전체 게시물의 갯수를 가져온다(페이징 처리시 필요)
            int dataCount = postService.getDataCount(map);

            //페이징 처리를 한다(준비 단계)
            //numPerPage: 페이지당 보여줄 게시물 목록의 갯수
            pagingUtil.resetPaging(dataCount, 5);

            map.put("start", pagingUtil.getStart());
            map.put("end", pagingUtil.getEnd());

            List<Post> lists = postService.getPostList(map);

            String param = "";
            String listUrl = "/list";
            String articleUrl = "/view?pageNum=" + pagingUtil.getCurrentPage();

            if (searchValue != null && !searchValue.equals("")) {
                param = "searchKey=" + searchKey;
                param += "searchValue=" + URLEncoder.encode(searchValue, "UTF-8");
            }

            if (!param.equals("")) {
                listUrl += "?" + param;
                articleUrl += "&" + param;
            }

            String pageIndexList = pagingUtil.pageIndexList(listUrl);

            model.addAttribute("lists", lists);
            model.addAttribute("articleUrl", articleUrl);
            model.addAttribute("pageIndexList", pageIndexList);
            model.addAttribute("dataCount", dataCount);
            model.addAttribute("searchValue", searchValue);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "post/list";
    }

    @GetMapping(value = "/write") // localhost/write
    public String write() {
        return "post/write";
    }

    @PostMapping(value = "/insert")
    public String insertPost(Post post, HttpSession session) {
        try {
            // 1.세션에서 사용자 user_id 가져오기
            Object userId = session.getAttribute("user_id");

            if (userId == null) {
                return "redirect:/login"; //세션 만료시 로그인 페이지로 이동
            } else {
                post.setUserId((int)userId); // insert 하기 전 userId 값 넣어준다.
                postService.insertPost(post); // 2. 포스트에 insert 해주는 서비스 호출
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/list";
    }

    @GetMapping(value = "/rewrite") // localhost/rewrite
    public String rewrite(HttpServletRequest request, Model model) {
        try {
            int postId = Integer.parseInt(request.getParameter("postId"));
            String pageNum = request.getParameter("pageNum");
            String searchKey = request.getParameter("searchKey");
            String searchValue =request.getParameter("searchValue");

            //게시물 데이터 가져오기
            Post post = postService.getReadPost(postId);

            //게시물이 없으면 list 페이지로 이동
            if (post == null) return "redirect:/list?pageNum=" + pageNum;

            String params = "pageNum=" + pageNum;

            if(searchValue != null && !searchValue.equals("")) {
                searchValue = URLDecoder.decode(searchValue, "UTF-8");
                //검색어가 있다면
                params += "&searchKey=" + searchKey;
                params += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); //컴퓨터의 언어로 인코딩
            }

            model.addAttribute("post", post);
            model.addAttribute("params", params);
            model.addAttribute("pageNum", pageNum);
            model.addAttribute("searchKey", searchKey);
            model.addAttribute("searchValue", searchValue);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "post/rewrite";
    }

    @PostMapping(value = "/update") // localhost/update
    public String update(Post post, HttpSession session, HttpServletRequest request) {
        String param = "";

        try {
            String pageNum = request.getParameter("pageNum");
            String searchKey = request.getParameter("searchKey");
            String searchValue = request.getParameter("searchValue");
            param = "postId=" + post.getPostId() + "&pageNum=" + pageNum;

            if(searchValue != null && !searchValue.equals("")) {
                searchValue = URLDecoder.decode(searchValue, "UTF-8");
                //검색어가 있다면
                param += "&searchKey=" + searchKey;
                param += "&searchValue=" + URLEncoder.encode(searchValue, "UTF-8"); //컴퓨터의 언어로 인코딩
            }

            Object userId = session.getAttribute("user_id");

            if (userId == null) {
                return  "redirect:/login"; //세션 만료시 로그인 페이지로 이동
            } else {
                postService.updatePost(post); //포스트 update 서비스 호출
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:/view?" + param;
    }

    @DeleteMapping(value = "/delete/{postId}")
    public @ResponseBody ResponseEntity deletePost(@PathVariable("postId") int postId, HttpSession session) {
        try {

            Object userId = session.getAttribute("user_id");

            if(userId == null) {
                return new ResponseEntity<String>("삭제 권한이 없습니다.", HttpStatus.UNAUTHORIZED);

            } else {
                postService.deletePost(postId);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("삭제 실패! 관리자에게 문의하세요.", HttpStatus.BAD_REQUEST);
        }

        //ResponseEntity<첫번째 매개변수의 타입>(result 결과, response 상태코드)
        //HttpStatus.OK 일때는 ajax의 success 함수의 결과로 출력된다
        return new ResponseEntity<Integer>(postId, HttpStatus.OK);
    }

    //서버에 이미지 업로드 request
    @PostMapping(value = "/postImgUpload")
    public String postImgUpload(MultipartHttpServletRequest request, Model model) {

        // /images/~-~-~.jpg
        String uploadPath = photoUtil.ckUpload(request);

        model.addAttribute("uploaded", true);
        model.addAttribute("url", uploadPath);

        /*
            {
                "uploaded" : true,
                "url" : uploadPath
            }
         */

        return "jsonView"; //model에 있는 값들이 json 객체 형식으로 forward 된다
    }
}
