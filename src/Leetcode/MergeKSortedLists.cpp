//
// Created by Pineapple on 2025/6/30.
//

#include<iostream>
#include <queue>
#include <vector>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

ListNode* mergeKLists(vector<ListNode*>& lists) {

    auto compare = [](ListNode* l, ListNode* r) {
        return l->val > r->val;
    };
    ListNode* dummy = new ListNode(-1);
    ListNode* cur = dummy;
    priority_queue<ListNode*, vector<ListNode*>, decltype(compare)> pq(compare);

    for (auto & l : lists) {
        if (l)
            pq.push(l);
    }
    while (!pq.empty()) {
        cur->next = pq.top();
        pq.pop();
        cur = cur->next;
        if (cur->next) {pq.push(cur->next);}
    }
    return dummy->next;
}

int main() {
    ListNode *l1 = new ListNode(1);
    l1->next = new ListNode(4);
    l1->next->next = new ListNode(5);

    ListNode *l2 = new ListNode(1);
    l2->next = new ListNode(3);
    l2->next->next = new ListNode(4);

    ListNode *l3 = new ListNode(2);
    l3->next = new ListNode(6);

    vector<ListNode*> lists = {l1, l2, l3, NULL};
    ListNode *l4 = mergeKLists(lists);
    while(l4) {
        cout << l4->val << endl;
        l4 = l4->next;
    }
}
