/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.edu.udb.biblioteca;

import javax.swing.text.AttributeSet;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class LimitarCaracter extends PlainDocument{
	private JTextField editor;
	private int num;
		public LimitarCaracter(JTextField editor, int num){
	this.editor = editor;
	this.num = num;
}

public void insertString(int arg0,String arg1, AttributeSet arg2) throws BadLocationException{
if((editor.getText().length()+arg1.length()) > this.num) {
return;
}super.insertString(arg0, arg1, arg2);
}
}






 