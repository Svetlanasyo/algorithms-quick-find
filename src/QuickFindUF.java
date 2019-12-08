import java.io.*;

public class QuickFindUF {

    private int [] id;

    public QuickFindUF(int N) {
        id = new int[N];
        for (int i=0; i<N; i++) {
            id[i]=i;
        }
    }

    public boolean connected (int p, int q) {
        return id[p] == id[q];
    }

    public void union (int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if(id[i] == pid) id[i] = qid;
        }
    }


    public static void main(String[] args) throws IOException {

        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String N = bufferedReader.readLine();
        int intN = Integer.parseInt(N);
        QuickFindUF uf = new QuickFindUF(intN);
        while (true) {
            String p = bufferedReader.readLine();
            int intP;
            intP = Integer.parseInt(p);
            String q = bufferedReader.readLine();
            int intQ = Integer.parseInt(q);
            if (!uf.connected(intP, intQ)) {
                uf.union(intP, intQ);
                System.out.println(intP + " " + intQ);
            }
        }
    }
}
