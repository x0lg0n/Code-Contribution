#include <stdio.h>
#include<stdlib.h>
typedef struct Node LL;
struct Node{
    int val;
    LL* next;
};
LL* insertBegin(LL* head,int val){
    LL* node =(LL*)malloc(sizeof(LL));
    if(node==NULL){
        printf("No memory\n");
        return node;
    }
    node->val=val;
    node->next=head;
    return node;
}
LL* deleteBegin(LL * head){
    if(head==NULL){
        printf("No node present to delete\n");
        return head;
    }
    LL* temp=head;
    head=head->next;
    free(temp);
    return head;
}
LL* search(LL* head,int val){
    if(head==NULL){
        printf("No node present\n");
        return head;
    }
    LL* temp = head;
    while(temp->next!=NULL){
        if(temp->val==val){
            return temp;
        }
        temp=temp->next;
    }
    return NULL;
}
LL* insertAfter(LL* head,int s,int val){
    if(head==NULL){
        printf("No Node found\n");
        return NULL;
    }
    LL* temp=search(head,s);
    if(temp==NULL){
        printf("NO Node found\n");
        return head;
    }
    LL* node =(LL*)malloc(sizeof(LL));
    if(node==NULL){
        printf("No memory\n");
        return node;
    }
    node->val=val;
    node->next=temp->next;
    temp->next=node;
    return head;
    
    
}
void printLL(LL* head){
    while(head!=NULL){
        printf("%d -> ",head->val);
        head=head->next;

    }
    printf("NULL\n");
}

LL* deleteAfter(LL* head,int val){
    if(head==NULL){
        printf("No Node found\n");
        return NULL;
    }
    LL* temp=search(head,val);
    if(temp==NULL){
        printf("NO Node found\n");
        return head;
    }
    LL* node=temp->next;
    temp->next=node->next;
    free(node);
    return head;
}
int main(){
    //testing
    LL* head=NULL;
    int arr[]={1,2,3,4,5};
    for(int i=0;i<5;i++){
        head=insertBegin(head,arr[i]);
    }
    head=insertAfter(head,4,6);
    head=deleteAfter(head,3);
    head=deleteBegin(head);
    printLL(head);
}