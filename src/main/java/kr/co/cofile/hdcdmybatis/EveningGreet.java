package kr.co.cofile.hdcdmybatis;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EveningGreet implements Greet {

	@GetMapping("/evening")
	@Override
	public void greeting() {
		System.out.println("편안한 밤입니다.");
	}

}
