package th.co.aware.etda.ws.dopa.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import th.co.aware.etda.ws.dopa.service.PostService;
import th.co.aware.etda.ws.dopa.web.form.CommentForm;
import th.co.aware.etda.ws.dopa.web.form.PostForm;

@Controller
public class PostController {

	private static final Logger log = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	@PostMapping("/post")
	String post(@Valid @ModelAttribute("postForm") PostForm postForm, BindingResult result, Model model) {
		log.info(postForm.toString());
		if (!result.hasErrors()) {
			postService.save(postForm);
			log.info("post success");
			model.addAttribute("posts", postService.listPost(postForm.getUserId()));
		}
		return "hello";
	}

	@PostMapping("/comment")
	String comment(@Valid @ModelAttribute("commentForm") CommentForm commentForm, BindingResult result, Model model) {
		log.info(commentForm.toString());
		if (!result.hasErrors()) {
			postService.saveComment(commentForm);
		}
		return "redirect:/";
	}
}