public class stringManager {
    String dataSt;
    char[] data;
    int length;
    stringManager(String data)  {
        this.dataSt = data;
        this.length = data.length();
        this.data = this.dataSt.toChar();
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
}