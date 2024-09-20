class Solution {
    public List<Integer> majorityElement(int[] nums) {
//        int candidate1=0;int candidate2=0;
//        int count1=0;int count2=0;

//        for(int num:nums){
//            if(num==candidate1){
//                count1++;
//            }else if(num==candidate2){
//                count2++;
//            }else if(count1 ==0){
//             candidate1=num;
//              count1=1;
//            }else if(count2==0){
//                candidate2=num;
//                count2=1;
//            }else{
//                count1--;
//                count2--;
//            }
//        } 
//            count1 = 0;
//     count2 = 0;

//     // Count the occurrences of the candidates
//     for (int num : nums) {
//         if (num == candidate1) {
//             count1++;
//         } else if (num == candidate2) {
//             count2++;
//         }
//     }
//     count1 = 0;
//     count2 = 0;

//     // Count the occurrences of the candidates
//     for (int num : nums) {
//         if (num == candidate1) {
//             count1++;
//         } else if (num == candidate2) {
//             count2++;
//         }
//     }
//   // Reset the counters to count the actual occurrences
//     count1 = 0;
//     count2 = 0;

//     // Count the occurrences of the candidates
//     for (int num : nums) {
//         if (num == candidate1) {
//             count1++;
//         } else if (num == candidate2) {
//             count2++;
//         }
//     }
//        List<Integer>result=new ArrayList<>();
//        int n=nums.length;
//        if(count1>n/3){
//            result.add(candidate1);
//        }if(count2>n/3){
//            result.add(candidate2);
//        }
//        return result;
//     }



        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey());
            }
        }

        return result;
    }


}