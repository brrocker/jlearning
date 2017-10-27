package object;

import basic.Ut;

public class Child implements action {
	public void eat(){
		Ut.pt("eating!");
	}
	public void laugh(){
		Ut.pt("laughing!");
	}
}
