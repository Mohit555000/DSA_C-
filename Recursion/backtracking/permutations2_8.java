//https://leetcode.com/problems/permutations-ii/?envType=problem-list-v2&envId=backtracking
class Solution {
    Set<List<Integer>> set=new HashSet<>();
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void help(int[] nums,List<List<Integer>> ans,List<Integer> permutation,int index){
        //base case
        if(index==nums.length){
            List<Integer> temp=new ArrayList<>(permutation);
            //Collections.sort(temp);
            if(!set.contains(temp)){
                set.add(temp);
                ans.add(temp);
            }
            return;
        }
        //processing Now i have to iterate on all the elements to make sure each elemets in in the index position
        for(int i=index;i<nums.length;i++){
            //swap
            swap(nums,i,index);
            //add the element
            permutation.add(nums[index]);
            //done with one case, now recursion will handle
            help(nums,ans,permutation,index+1);
            //now backtrackng
            permutation.remove(permutation.size()-1);
            //remake the original array
            swap(nums,i,index);

        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> permutation=new ArrayList<>();
        int index=0;
        help(nums,ans,permutation,index);
        return ans;
    }
}


✅ BIG PICTURE — YE CODE KYA KAR RAHA HAI?

Simple language mein:

✅ Ye code ek-ek karke
har number ko har position pe bithata hai
phir recursion se aage ke numbers set karta hai
phir peeche aakar (backtrack) sab undo karta hai

✅ IMPORTANT VARIABLES SIMPLE SHABDON MEIN
Variable	Meaning
nums	Original array
index	Kaun si position fill karni hai
i	Kaun sa element us position pe bithana hai
permutation	Ab tak ka bana hua answer
ans	Final list
set	Duplicate answer rokne ke liye
✅ INDEX & i KO EK LINE MEIN SAMAJH

✅ index = kaun si Kursi khali hai
✅ i = kaun sa baccha us kursi pe baithega

✅ FIVE CORE STEPS (VERY IMPORTANT)

Har loop mein ye 5 kaam repeat hote hain:

SWAP → ADD → RECURSIVE CALL → REMOVE → UNSWAP


Matlab:
1️⃣ kursi badlo
2️⃣ value daalo
3️⃣ aage bhejo
4️⃣ hatao
5️⃣ wapas original karo

✅ DRY RUN (nums = [1, 2, 3])
START:
index = 0
permutation = []
nums = [1,2,3]

🔁 LEVEL 1 (index = 0)
i = 0
swap(0,0) → [1,2,3]
add nums[0] → permutation = [1]
call help(index=1)

🔁 LEVEL 2 (index = 1)
i = 1
swap(1,1) → [1,2,3]
add → [1,2]
call help(index = 2)

🔁 LEVEL 3 (index = 2)
i = 2
swap(2,2) → [1,2,3]
add → [1,2,3]
call help(index = 3)

✅ BASE CASE HIT (index == 3)
[1,2,3] is stored in ans

🔙 BACKTRACK START
remove 3 → [1,2]
unswap


Phir:

remove 2 → [1]
unswap


Phir:

remove 1 → []
unswap


Ab next i chalega.

Isi tarah:

[1,3,2]
[2,1,3]
[2,3,1]
[3,1,2]
[3,2,1]


sab ban jaate hain ✅

✅ YE LINE KYU IMPORTANT HAI?
permutation.remove(permutation.size() - 1);


Iska matlab:

❌ Galat element hata do
✅ jaisa pehle tha waisa state lao

Agar ye line nahi likhenge to:
❌ Old values chipak jaayengi
❌ Galat permutations banenge

✅ YE LINE KYU IMPORTANT HAI?
swap(nums,i,index);


Last mein jo dubara hua swap:

✅ Original array wapas lao
✅ taaki next choice sahi bane

✅ SET KYU USE KIYA?

Kyuki duplicate input ho sakta hai:

[1,2,2]


To:

[2,1,2]
[2,1,2]   ❌ duplicate


Set duplicate allow nahi karta ✅

✅ RECURSION TREE KA SIMPLE LOGIC

Har level ek position ko fix karta hai

Level 0 → first position
Level 1 → second position
Level 2 → third position


Aur har level pe:

har available number try hota hai

✅ FINAL SUMMARY (EXAM READY)

✅ Ye algorithm Backtracking + Swapping use karta hai
✅ index decide karta hai kaunsi position fill hogi
✅ i decide karta hai kaunsa element aayega
✅ swap() value ko us position pe laata hai
✅ permutation.add() value store karta hai
✅ help() agli position ko bhejta hai
✅ remove() galat choice hatata hai
✅ swap() dubara original state laata hai
✅ Set duplicate permutations se bachata hai

✅ ONE LINE MEIN CONCEPT

Pick one element → lock it → solve rest → unlock it → try next

  Example lete hain:

nums = [1, 2, 3]

✅ TREE KA MATLAB KYA HOTA HAI?

Tree ka matlab:

Har recursive call ek node hota hai
Har choice ek branch hoti hai
Last tak jaake ek permutation ban jaata hai

✅ LEVEL WISE SOCHO
Level	index	kaunsa position fix ho raha
Level 0	index = 0	first position
Level 1	index = 1	second position
Level 2	index = 2	third position
Level 3	index = 3	base case → answer store
✅ COMPLETE RECURSION TREE (ASCII FORMAT)

Main exact tera code ka flow follow kar raha hoon:

START:
nums = [1,2,3]
permutation = []
index = 0

🌳 LEVEL 0 (index = 0)

Loop: i = 0 to 2
➡️ First position ke liye 3 choices

                         []
                  /          |           \
               1            2             3

🔹 Branch 1: First position = 1
swap(0,0) → [1,2,3]
permutation = [1]
call help(index = 1)

🌳 LEVEL 1 (index = 1) under [1]
                       [1]
                  /             \
               2                   3

🔹 Branch 1.1: [1,2]
swap(1,1) → [1,2,3]
permutation = [1,2]
call help(index = 2)

🌳 LEVEL 2 (index = 2) under [1,2]
                      [1,2]
                          |
                          3

✅ Branch 1.1.1 → [1,2,3]
swap(2,2)
permutation = [1,2,3]
call help(index = 3)


✅ BASE CASE HIT → STORE:

[1,2,3]


🔙 BACKTRACK:

remove 3 → [1,2]
unswap
remove 2 → [1]
unswap

🔹 Branch 1.2: [1,3]
swap(2,1) → [1,3,2]
permutation = [1,3]

🌳 LEVEL 2 under [1,3]
                     [1,3]
                         |
                          2


✅ STORE:

[1,3,2]


🔙 BACKTRACK to:

[]

🌳 LEVEL 0 CONTINUES
🔹 Branch 2: First position = 2
swap(1,0) → [2,1,3]
permutation = [2]

                [2]
             /         \
           1             3


✅ Results:

[2,1,3]
[2,3,1]

🔹 Branch 3: First position = 3
swap(2,0) → [3,2,1]
permutation = [3]

                [3]
             /         \
           2             1


✅ Results:

[3,2,1]
[3,1,2]

✅ FINAL TREE (COMPLETE VIEW)
                          []
             /               |                \
         [1]                [2]                 [3]
       /     \           /     \             /     \
   [1,2]   [1,3]     [2,1]   [2,3]        [3,2]    [3,1]
     |         |        |        |            |         |
 [1,2,3]   [1,3,2]  [2,1,3] [2,3,1]      [3,2,1]   [3,1,2]

✅ TREE SE CODE KA FLOW MATCH KARO
Code Line	Tree Ka Meaning
for(i = index; i < n; i++)	Branch ban rahi hai
swap(i,index)	Node ki value decide
permutation.add()	Tree mein value add
help(index+1)	Next level pe jaa rahe
remove()	Branch se wapas
swap()	Tree reset
✅ BACKTRACKING KA CHILD-LEVEL LOGIC

Soch:

Tum game khel rahe ho
har door khol ke dekh rahe ho
andar jaake dekhte ho
agar galat nikla → wapas bahar aate ho
phir next door try karte ho

Yahi backtracking hai ✅

✅ ONE LINE SUMMARY

Har level ek position fix karta hai,
har branch ek new number try karti hai,
last level pe permutation complete hota hai,
fir backtracking se wapas jaake next option try hota hai.
