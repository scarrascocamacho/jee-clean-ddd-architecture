/**
 *
 */
package jeecleandddarchitecture.helloworld.boundary;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jeecleandddarchitecture.helloword.entity.HelloWorldDto;

/**
 * @author scarrasco
 *
 */
// Controller
@RestController
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	@GetMapping(path = "/hello-world-bean")
	public HelloWorldDto helloWorldDto() {
		return new HelloWorldDto("Hello World From a Java Bean");
	}
	
	/// hello-world/path-variable/helloworld
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldDto helloWorldPathVariable(@PathVariable final String name) {
		// throw new RuntimeException("Something went wrong");
		return new HelloWorldDto(String.format("Hello World, %s", name));
	}
}
