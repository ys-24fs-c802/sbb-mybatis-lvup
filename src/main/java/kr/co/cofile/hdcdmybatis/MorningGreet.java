package kr.co.cofile.hdcdmybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MorningGreet implements Greet {

	@GetMapping("/morning")
	@Override
	public void greeting() {
		System.out.println("좋은 아침입니다.");
	}

}
