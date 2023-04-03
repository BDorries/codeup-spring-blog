package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.controllers.models.EmailService;
import com.codeup.codeupspringblog.controllers.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService){
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
    }
    @GetMapping("/posts")
    public String all(Model model){
        try{
            List<Post> posts = postDao.findAll();
            model.addAttribute("posts", posts);
        }catch(Exception e){
            //handle
        }
        model.addAttribute("title", "Home");
        return "/posts/index";
    }

    @GetMapping("/posts/{postId}")
    @ResponseBody
    public String posts(@PathVariable long postId){
        Post post = postDao.findById(postId).get();
        return "show/"+postId;
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    public String create(Model model, PostRepository postDao){
        model.addAttribute("title", "Create");
        return "posts/createPost";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post){
        long userId = 1;
        post.setUser(userDao.findById(userId).get());
        String subjLine = "New post created";
        String emailBody = "This is the body... hide it well";
        emailService.prepareAndSend(post,subjLine, emailBody);

        postDao.save(post);
        return "redirect:/posts";
    }


}
