package ServerSide;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UnixCommander {
	
	public String runCommand(String command) {
		Process process;
    	StringBuilder out = new StringBuilder();
    	
    	try {
    		//System.out.print("running ");
    		
        	
        	if(command.toLowerCase().contains("&&") || command.toLowerCase().contains("|")){
        		String[] cmd1 =  { "/bin/bash", "-c", command};
        		process = Runtime.getRuntime().exec(cmd1);
        		process.waitFor();
        	}
        	else {
        		process = Runtime.getRuntime().exec(command);
        		process.waitFor();
        	}
        	
    		System.out.print(command);
    		//process.waitFor();
    		InputStream in = process.getInputStream();
       
    		BufferedReader br = new BufferedReader(new InputStreamReader(in));
    		
    		String result="";
    		while((result = br.readLine()) != null) {
    			out.append(result + "\n");
    		}
    		
    		
    		
    		in.close();
    		
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	  }
    	return out.toString();
	}

}