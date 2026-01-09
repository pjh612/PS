package java.P14719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());

    int h = Integer.parseInt(st.nextToken());
    int w= Integer.parseInt(st.nextToken());
    int []height = new int[w];
    int maxHeightIndex =0;
    int maxHeight =0;
    st = new StringTokenizer(br.readLine());
    for(int i=0;i<w;i++)
    {
      height[i] = Integer.parseInt(st.nextToken());
      if(maxHeight < height[i])
      {
        maxHeight = height[i];
        maxHeightIndex = i;
      }
    }
    int temp = height[0];
    int answer =0 ;
    for(int i=1;i<=maxHeightIndex;i++)
    {
      if(temp >= height[i])
        answer+= (temp-height[i]);
      else
        temp = height[i];
    }
    temp = height[w-1];
    for(int i= w-1 ;i> maxHeightIndex;i--)
    {
      if(temp >= height[i])
        answer+= (temp-height[i]);
      else
        temp = height[i];
    }
    System.out.println(answer);
  }

}
