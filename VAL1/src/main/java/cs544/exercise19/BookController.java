package cs544.exercise19;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
	
	@Resource
	public IBookDao bookDao;
	
	@RequestMapping("/")
	public  String redirector(){
		return "redirect:/books";
	}
	
	@RequestMapping(value="/addbooks", method=RequestMethod.GET)
	public String adder(@ModelAttribute("books")Book book){
		
		return "addBook";
	}
	
	@RequestMapping(value="/books", method=RequestMethod.GET)
	public String getAll(Model model){
		
		model.addAttribute("books", bookDao.getAll());
		return "bookList";
	}
	
	@RequestMapping(value="books", method=RequestMethod.POST)
	public String add(@Valid Book books, BindingResult result){
		String view = "redirect:books";
		
		if(result.hasErrors())
			return "addBook";
		else
		bookDao.add(books);
		return view;
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("book", bookDao.get(id));
		return "bookDetail";
	}
	
	@RequestMapping(value="/books/{id}", method=RequestMethod.POST)
	public String update(Book book , @PathVariable int id) {
		bookDao.update(id, book);
		return "redirect:/books";
	}
	
	@RequestMapping(value="/books/delete", method=RequestMethod.POST)
	public String delete(int bookId) {
		bookDao.delete(bookId);
		return "redirect:/books";
	}

}
