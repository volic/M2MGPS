/*
 * This file is part of the QuickServer library 
 * Copyright (C) 2003-2005 QuickServer.org
 *
 * Use, modification, copying and distribution of this software is subject to
 * the terms and conditions of the GNU Lesser General Public License. 
 * You should have received a copy of the GNU LGP License along with this 
 * library; if not, you can download a copy from <http://www.quickserver.org/>.
 *
 * For questions, suggestions, bug-reports, enhancement-requests etc.
 * visit http://www.quickserver.org
 *
 */

package dateserver;

import java.net.*;
import java.io.*;
import java.util.Date;
import org.quickserver.net.server.*;

public class ObjectHandler implements ClientObjectHandler {

	public void handleObject(ClientHandler handler, Object command)
			throws SocketTimeoutException, IOException {
		
		Date gotDate = (Date) command;
		handler.sendSystemMsg("Got Client Date : " + gotDate);
		//change it back so that you can get normal messages
		handler.setDataMode(DataMode.STRING, DataType.IN);
	}
}
