#include <iostream>
#include <cstring>
using namespace std;
void toUppercase(char ch[],int n){
    int index=0;
    while(ch[index]!='\0'){
        char currCharacter=ch[index];
        if(currCharacter>='a' && currCharacter <='z'){
            ch[index]=currCharacter - 'a' + 'A';
        }
        index++;
    }
}

int main(){
    char ch[100];

    cin.getline(ch,100);

    int length_string=strlen(ch);
    cout<<"Before "<< ch <<endl;
    toUppercase(ch,length_string);
    cout<<"After "<< ch <<endl;

}