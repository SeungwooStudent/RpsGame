package com.seungwoo.gym;

import java.util.LinkedList;
public class GymManager {
    LinkedList<Member> members = new LinkedList<>();
    public void addMember(Member member) {
        members.add(member);
    }
    public void deleteMember(String removeMamber) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getID().equals(removeMamber)) {
                members.remove(i);
            }
        }
    }
    public int findMember(String phonNumberTest) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            if (member.getID().equals(phonNumberTest)) {
                return i;
            }
        }
        return -1;
    }
    public void changeName(int findIndex, String changeName) {
        members.get(findIndex).setName(changeName);
    }
    public void changeAge(int findIndex, int changeAge) {
        members.get(findIndex).setAge(changeAge);
    }
    public void changePhonNumber(int findIndex, String changePhoneNumber) {
        members.get(findIndex).setPhoneNumber(changePhoneNumber);
    }
    public void searchMember(String phoneNumber) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getID().equals(phoneNumber)) {
                members.get(i).introduceMyself();
                return;
            }
        }
    }
    public boolean CheckID(String memberId) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getID().equals(memberId)) {
                return true;
            }
        }
        return false;
    }
    public void printAll() {
        for (int i = 0; i < members.size(); i++) {
            members.get(i).introduceMyself();
        }
    }

    public boolean isCheckID(String removeID) {
        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getID().equals(removeID)) {
                return true;
            }
        }
        return false;
    }

}
