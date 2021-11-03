    import java.io.*;
    import java.util.*;


    public class Main {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        static class Word implements Comparable<Word>
        {
            String w;
            int freq;
            @Override
            public int compareTo(Word o) {
                if(this.freq == o.freq) {

                    if(this.w.length() == o.w.length()) {
                        return this.w.compareTo(o.w);
                    }
                    return o.w.length() - w.length();
                }
                else return (o.freq - this.freq);
            }

            public Word(String w, int freq) {
                this.w = w;
                this.freq = freq;
            }
        }
        public static void main(String[] args) throws IOException {
            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<String, Word> map = new HashMap<>();
            int n =Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<String> wordSet = new ArrayList<>();
            List<Word> ans = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String s = br.readLine();
                if(s.length() >=m)
                {
                    if(map.containsKey(s))
                    {
                        map.get(s).freq++;
                    }
                    else {
                        map.put(s, new Word(s, 0));
                        wordSet.add(s);
                    }
                }
            }

            for(int i=0;i<wordSet.size();i++)
            {
                ans.add(map.get(wordSet.get(i)));
            }
            Collections.sort(ans);
            for(int i=0;i<ans.size();i++)
            {
                bw.write(ans.get(i).w+"\n");
            }
            bw.flush();


        }
    }