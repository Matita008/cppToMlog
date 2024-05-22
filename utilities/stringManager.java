package utilities;
import java.util.*;

public class stringManager {
    String dataSt;
    char[] data;
    int length;
    ArrayList<String> op = new ArrayList<String>();
    stringManager(String data)  {
        this.dataSt = data;
        this.length = data.length();
        this.data = this.dataSt.toCharArray();
        loadBaseOp();
    }
    public final int countOp()  {
    	char empty = ' ';
    	int n = 3;
    	@SuppressWarnings("unchecked")
		char[][] op = converter.toChar((ArrayList<String>) this.op.clone());
    	return countOcc(op, n, empty);
    }
    public final int countOcc(char[][] value,int nChar) {
    	return countOcc(value, nChar, '\u0000');
    }
    public final int countOcc(char[][] value,int nChar,char any)  {
        int count = 0;
        for(int i = 0; i < length - nChar; i++)  {
            boolean done = false;
            for (char val[] : value)  {
            for(int n = 0; n < nChar; n++)  {
                if(done || val[n] != this.data[i+n])   n = nChar + 1;
                if(n == nChar) done = true;
              }
            }
            if (done) count++;
        }
        return count;
    }
    public final int getOpPos(int index ) {
    	int count,rtn = 0;
    	for(int i = 0; i < length - 3; i++)  {
            boolean done = false;
            for (String opSt : op)  {
            	char[] val = opSt.toCharArray();
            for(int n = 0; n < 3; n++)  {
                if(done || val[n] != this.data[i+n])   n = 3 + 1;
                if(n == 3) done = true;
              }
            }
            if (done) count++;
        }
    	return rtn
    }
    public final void loadBaseOp()  {
    	op.add(" + ");
    	op.add(" - ");
    	op.add(" * ");
    	op.add(" / ");
    	op.add("<< ");
    	op.add(">> ");
	}
}