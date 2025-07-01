//
// Created by Pineapple on 2025/6/30.
// https://leetcode.com/problems/two-sum/
//

#include<stdio.h>
#include<iostream>
#include<vector>
#include<algorithm>
#include<unordered_map>

using namespace std;



vector<int> twoSum(vector<int>& nums, int target) {
    //vector<int> res;
    unordered_map<int, int> myMap;

    for(int i = 0; i < nums.size();i++){
        int remain = target - nums[i];
        if(myMap.count(remain)){
            return {myMap[remain],i};
        }

        myMap[nums[i]] = i;
    }

    return {};
}

int main() {
    vector<int> nums = {2,7,11,15};
    int target = 9;
    vector<int> result = twoSum(nums, target);
    cout<<result[0]<<" "<<result[1]<<endl;
}