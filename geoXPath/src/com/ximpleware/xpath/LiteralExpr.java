/* 
 * Copyright (C) 2002-2007 XimpleWare, info@ximpleware.com
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package com.ximpleware.xpath;
import com.ximpleware.VTDNav;
/**
 * This class represents a literal string XPath expression
 * 
 */
public class LiteralExpr extends Expr {
	public String s;
	public LiteralExpr (String st){
		s = st;
	}	
	public String toString(){
		boolean b = true;
		for(int i = 0;i<s.length();i++){
			if (s.charAt(i) == '\''){
				b = false;
				break;
			}
		}
		if (b == true)
		  return "\""+s+"\"";
		else 
		  return "'" + s + "'";
	}

	public boolean evalBoolean(VTDNav vn){
		return s.length() != 0;
	}

	public double evalNumber(VTDNav vn){
		try {
			double dval = Double.parseDouble(s);
			return dval;
		}catch (NumberFormatException e){
			return Double.NaN;
		}	
	}
		
	public int evalNodeSet(VTDNav vn) throws XPathEvalException{
		
		throw new XPathEvalException("LiteralExpr can't eval to a node set!");
	}
	
        public String evalString(VTDNav vn){
		return s;
	}

	public void reset(VTDNav vn){ }

		public boolean  isNodeSet(){
		return false;
	}

	public boolean  isNumerical(){
		return false;
	}
	
	public boolean isString(){
	    return true;
	}
	
	public boolean isBoolean(){
	    return false;
	}
	// to support computer context size 
	// needs to add 
	public boolean requireContextSize(){
	    return false;
	}
	
	public void setContextSize(int size){	    
	}
	
	public void setPosition(int pos){
	    
	}
	public int adjust(int n){
	    return 0;
	}
}
