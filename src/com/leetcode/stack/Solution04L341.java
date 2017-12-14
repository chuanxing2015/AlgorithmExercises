package com.leetcode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution04L341 {


    public static class NestedIterator implements Iterator<Integer> {

        private LinkedList<Integer> que;

        public NestedIterator(List<NestedInteger> nestedList) {
            if(nestedList != null && nestedList.size() != 0){
                que = new LinkedList<>();
                getInteger(nestedList);
            }
        }

        @Override
        public Integer next() {
            if(que != null){
                return que.pop();
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            if(que == null){
                return false;
            }
            return que.peek() != null;
        }

        private void getInteger(List<NestedInteger> nestedList){

            for(int i = 0;i < nestedList.size();i++){
                NestedInteger bean = nestedList.get(i);
                if(bean.isInteger()){
                    que.offer(bean.getInteger());
                }else{
                    getInteger(bean.getList());
                }
            }
        }

    }




    public interface NestedInteger{

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }


    public static class IntegerBean implements NestedInteger{

        public Integer data;
        public List<NestedInteger> listData;
        public boolean mIsInteger;

        public IntegerBean(Integer data){
            mIsInteger = true;
            this.data = data;
        }

        public IntegerBean(List<NestedInteger> listData){
            mIsInteger = false;
            this.listData = listData;
        }


        @Override
        public boolean isInteger() {
            return mIsInteger;
        }

        @Override
        public Integer getInteger() {
            return data;
        }

        @Override
        public List<NestedInteger> getList() {
            return listData;
        }
    }


    public static void main(String[] args){

        IntegerBean bean1 = new IntegerBean(1);
        IntegerBean bean2 = new IntegerBean(2);
        IntegerBean bean3 = new IntegerBean(3);
        IntegerBean bean4 = new IntegerBean(4);
        IntegerBean bean5 = new IntegerBean(5);
        IntegerBean bean6 = new IntegerBean(6);

        ArrayList<NestedInteger> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);
        list.add(bean4);
        list.add(bean5);
        list.add(bean6);

        ArrayList<NestedInteger> list1 = new ArrayList<>();
        list1.add(bean3);
        list1.add(bean4);
        list1.add(bean5);
        IntegerBean bean7 = new IntegerBean(list1);

        list.add(bean7);




        NestedIterator iterator = new NestedIterator(list);
        while (iterator.hasNext()){
            System.out.print(iterator.next()+" ");
        }

    }
}

