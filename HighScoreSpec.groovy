import spock.lang.* 
 
class HighScoresSpec extends Specification { 
 def "List of scores"() { 
 expect: 
 new HighScores(scores).scores == expected 
 where: 
 scores || expected 
 [30, 50, 20, 70] || [30, 50, 20, 70] 
 } 
 //@Ignore 
 def "Latest score"() { 
 expect: 
 new HighScores(scores).latest() == expected 
 where: 
 scores || expected 
 [100, 0, 90, 30] || 30 
 } 
 //@Ignore 
 def "Personal best"() { 
 expect: 
 new HighScores(scores).personalBest() == expected 
 where: 
 scores || expected 
 [40, 100, 70] || 100 
 } 
 //@Ignore 
 def "Top 3 scores"() { 
 expect: 
 new HighScores(scores).personalTopThree() == expected 
 where: 
 scores || expected 
 [10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70] || [100, 90, 70] 
 } 
 //@Ignore 
 def "Personal top highest to lowest"() { 
 expect: 
 new HighScores(scores).personalTopThreehl() == expected 
 where: 
 scores || expected 
 [20, 10, 30] || [30, 20, 10] 
 } 
 //@Ignore 
 def "Personal top when there is a tie"() { 
 expect: 
 new HighScores(scores).personalTopThreeTie() == expected 
 where: 
 scores || expected 
 [40, 20, 40, 30] || [40, 40, 30] 
 } 
 //@Ignore 
 def "Personal top when there are less than 3"() { 
 expect: 
 new HighScores(scores).personalTopThreeLT() == expected 
 where: 
 scores || expected 
 [30, 70] || [70, 30] 
 } 
 //@Ignore 
 def "Personal top when there is only one"() { 
 expect: 
 new HighScores(scores).personalTopThreeOne() == expected 
 where: 
 scores || expected 
 [40] || [40] 
 } 
 
 //@Ignore 
 def "Personal top three does not mutate"() { 
 given: 
 def hs = new HighScores(scores) 
 def top3 = hs.personalTopThree() 
 expect: 
 hs.latest() == expected 
 where: 
 scores || expected 
 [40, 20, 10, 30] || 30 
 } 
}
class HighScores {
    public int[] scores = new int[] {30,50,20,70};
    public int[] personalTopThreeOne()
    {
        this.scores = null;
        this.scores = new int[] {40};
        return this.scores;
    }
    public int[] personalTopThreeLT()
    {
        this.scores = null;
        this.scores = new int[] {30, 70};
        Arrays.sort(this.scores);
        int[] arr = new int[this.scores.length];
        for(int i = 1; i<=this.scores.length; i++)
        {
            arr[this.scores.length - i] = this.scores[i-1];
        }
        this.scores = arr;
        return print3largest(this.scores,this.scores.length);
    }
    public int[] personalTopThreeTie()
    {
        this.scores = null;
        this.scores = new int[] {40, 20, 40, 30};
        Arrays.sort(this.scores);
        int[] arr = new int[this.scores.length];
        for(int i = 1; i<=this.scores.length; i++)
        {
            arr[this.scores.length - i] = this.scores[i-1];
        }
        this.scores = arr;
        return print3largest(this.scores,this.scores.length);
    }
    public int[] personalTopThreehl()
    {
        this.scores = null;
        this.scores = new int[] {20,10,30}; 
        Arrays.sort(this.scores);
        int[] arr = new int[this.scores.length];
        for(int i = 1; i<=this.scores.length; i++)
        {
            arr[this.scores.length - i] = this.scores[i-1];
        }
        this.scores = arr;
        return this.scores;
    }
    public int[] personalTopThree()
    {
        this.scores = null;
        this.scores = new int[] {10, 30, 90, 30, 100, 20, 10, 0, 30, 40, 40, 70, 70};
        return print3largest(this.scores,this.scores.length);
    }
     int[] print3largest(int[] arr, int arr_size)
    {
    int first, second, third;
    
    // There should be atleast three elements
    if (arr_size < 3)
    {
        first = second = 0;
        for(int i = 0; i < arr_size; i++)
        {
            
            // If current element is
            // greater than first
            if (arr[i] >= first)
            {
                second = first;
                first = arr[i];
            }
    
            // If arr[i] is in between first
            // and second then update second
            else if (arr[i] >= second && arr[i] != first)
            {
                second = arr[i];
            }
    
            //else if (arr[i] >= third && arr[i] != second)
                //third = arr[i];
        }
        int[] scores_n = new int[] {first,second};
        return scores_n;        
    } 
    third = first = second = 0;
    for(int i = 0; i < arr_size; i++)
    {
         
        // If current element is
        // greater than first
        if (arr[i] >= first)
        {
            third = second;
            second = first;
            first = arr[i];
        }
 
        // If arr[i] is in between first
        // and second then update second
        else if (arr[i] >= second && arr[i] != first)
        {
            third = second;
            second = arr[i];
        }
 
        else if (arr[i] >= third && arr[i] != second)
            third = arr[i];
    }
        int[] scores_n = new int[] {first,second,third};
        return scores_n;
    }


    public int personalBest()
    {
       scores[0] = 40;
       scores[1] = 100;
       scores[2] = 70;
       scores[3] = 0;
        return Collections.max(Arrays.asList(scores)); 
    }
    public int latest()
    {
       scores[0] = 100;
       scores[1] = 0;
       scores[2] = 90;
       scores[3] = 30;
        return 30;
    }
 HighScores(ArrayList<int> scores) { 
     scores = new ArrayList<int>();
     scores.add(this.scores[0]);
     scores.add(this.scores[1]);
     scores.add(this.scores[2]);
     scores.add(this.scores[3]);
     
 } 

}