public class stringManager {
    string data;
    int length;
    stringManager(string data)  {
        this.data = data;
        this.lenght = data.length();
    }
    int public final countOcc(char[][] value,int nChar,char any = "")  {
        int count = 0;
        for(int i = 0; i < length - nChar; i++)  {
            bool done = false;
            for each(char val[] : value)  {
            for(int n = 0; n < nChar; n++)  {
                if(done || )   n = nChar + 1;
                if(n == nChar) done = true;
              }
            }
            if (done) count++;
        }
        return count;
    }
}