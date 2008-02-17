/* 
 * Copyright (C) 2002-2008 XimpleWare, info@ximpleware.com
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
package com.ximpleware.transcode;

import com.ximpleware.TranscodeException;

public class ISO8859_1Coder {
    public static int getLen(int ch) throws TranscodeException{
        if (ch>255)
            throw new TranscodeException("Invalid UCS char for ASCII format");
        return 1;
    }
    
    public static long decode(byte[] input, int offset ){
        long l = input[offset] & 0xff;
        return (((long)(offset+1))<<32) | l ;
    }
    
    public static int encode(byte[] output, int offset, int ch ){
        output[offset] = (byte) ch;
        return offset+1;
    }
}