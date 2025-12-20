// https://leetcode.com/problems/edit-distance/description/

class Solution {
    int solve(StringBuilder sb1,StringBuilder sb2,int i,int j){
        if(j>=sb2.length()){
            //word 2 iterate kar ke kahatm ho gaya , but word 1 mai still baki hai words to that number of operations is still pending to calculate
            return sb1.length()-i;
        }
        if(i>=sb1.length()){
            return sb2.length()-j;
        }

        int ans=0;
        //match condition
        if(sb1.charAt(i)==sb2.charAt(j)){
            i=i+1;
            j=j+1;
            ans=0+solve(sb1,sb2,i,j);
        }
        //does not match condition
        else{
            //insert Character
            int option1=1+solve(sb1,sb2,i,j+1);
            //delete character
            int option2=1+solve(sb1,sb2,i+1,j);
            //replace a character
            int option3=1+solve(sb1,sb2,i+1,j+1);
            ans=Math.min(option1,Math.min(option2,option3));
        }
        return ans;
    }
    public int minDistance(String word1, String word2) {
        int i=0;
        int j=0;
        StringBuilder sb1=new StringBuilder(word1);
        StringBuilder sb2=new StringBuilder(word2);
        int ans=solve(sb1,sb2,i,j);
        return ans;
    }
}

Yeh code Edit Distance (Levenshtein Distance) problem ka solution hai. Iska aim hai word1 ko word2 mein convert karna minimum steps mein. Aap 3 cheezein kar sakte ho: Insert, Delete, ya Replace.

Intuition (Asli logic kya hai?)
Socho ki aapke paas do strings hain. Aap dono ke shuruat mein khade ho (i aur j pointers lekar).

Agar dono characters match kar gaye, toh tension khatam! Agle character pe chalo.

Agar match nahi kiya, toh aapke paas 3 raaste hain:

Insert: Maan lo aapne word2 ka character word1 mein daal diya. Toh word2 ka kaam ho gaya (j+1), par word1 ka pointer wahi rahega.

Delete: word1 ka character uda do. Pointer i+1 pe chala jayega.

Replace: word1 ke character ko badal kar word2 jaisa bana do. Dono pointers aage badh jayenge (i+1, j+1).

Humein in teeno options mein se woh chunna hai jisme sabse kam (minimum) mehnat lage.

  Line-by-Line Explanation (Hinglish)
Java

int solve(StringBuilder sb1, StringBuilder sb2, int i, int j) {
sb1, sb2: Hamari strings.

i, j: Current positions jinhe hum check kar rahe hain.

Java

if(j >= sb2.length()){
    return sb1.length() - i;
}
Base Case 1: Agar j khatam ho gaya (yani word2 poora ban gaya), lekin word1 mein abhi bhi characters bache hain, toh humein un bache hue characters ko delete karna padega. Isliye bacha hua length (sb1.length() - i) return kar rahe hain.

Java

if(i >= sb1.length()){
    return sb2.length() - j;
}
Base Case 2: Agar word1 khatam ho gaya par word2 abhi baki hai, toh humein naye characters insert karne padenge. Isliye sb2.length() - j return kiya.

Java

if(sb1.charAt(i) == sb2.charAt(j)){
    i = i + 1;
    j = j + 1;
    ans = 0 + solve(sb1, sb2, i, j);
}
Match Condition: Agar dono characters same hain, toh koi "cost" nahi lagegi (0 + ...). Bas dono pointers ko aage badha do.

Java

else {
    // insert Character
    int option1 = 1 + solve(sb1, sb2, i, j + 1);
Option 1 (Insert): Humne ek character insert kiya (isliye +1). Insert karne ke baad word2 ka character satisfy ho gaya, toh j+1 kiya, par word1 ka pointer i pe hi rakha.

Java

    // delete character
    int option2 = 1 + solve(sb1, sb2, i + 1, j);
Option 2 (Delete): word1 ka character delete kar diya (+1). Ab hum i+1 check karenge, par j wahi rahega kyunki word2 ka character abhi bhi match hona baki hai.

Java

    // replace a character
    int option3 = 1 + solve(sb1, sb2, i + 1, j + 1);
Option 3 (Replace): Humne character ko replace kiya (+1). Ab dono characters "virtually" match ho gaye, toh dono pointers i+1 aur j+1 ho gaye.

Java

    ans = Math.min(option1, Math.min(option2, option3));
}
return ans;
Hum teeno options (Insert, Delete, Replace) mein se jo minimum value de raha hai, usse choose kar rahe hain.
