import java.util.Queue;
import java.util.Stack;



public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		Stack<HtmlTag> st = new Stack<HtmlTag>();
		while(tags !=null){
		while(tags.element().isOpenTag()== true ||tags.element().isSelfClosing()==true ){
			if(tags.element().isSelfClosing()==true){tags.remove();}
			else{
			st.push(tags.element());
			tags.remove();
		}
		}
		while(tags.element().isOpenTag()!= true ){
			if (st.isEmpty()==true){
				return null;
			}
			else if(tags.element().matches(st.peek())){
				st.pop();
				tags.remove();
				if(tags.isEmpty()==true){return st;}
			}
			else{
				return  st;
			}
		}
		}
		return st; 
	}
	

}

