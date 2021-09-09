import java.util.*;

class Solution {
          static HashMap<String, String> map = new HashMap<>();
        static HashMap<String, Integer> result = new HashMap<>();
        static void givemoney(String now, int money)
        {
            if(now.equals("-"))
                return;
              if(money ==0 )
                return;
            String parent = map.get(now);
            int sum = money;
            int pres = sum * 10 /100;
            int mine = sum - pres;
            if(result.containsKey(now))
                result.put(now,result.get(now) + mine);
            else
                result.put(now,mine);
            givemoney(parent,pres);
        }
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
          int [] answer = new int[enroll.length];

            for(int i=0;i<enroll.length;i++)
            {
                map.put(enroll[i],referral[i]);
            }

            for(int i=0;i<seller.length;i++)
            {
                givemoney(seller[i],amount[i] * 100);

            }
            for(int i=0;i<enroll.length;i++)
            {
                if(result.containsKey(enroll[i]))
                answer[i] = result.get(enroll[i]);
                else
                    answer[i] =0;
                System.out.println(answer[i]);
            }

        return answer;
    }
}