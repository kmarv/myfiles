#!/bin/bash

echo  "Enter number to reverse"
read num
x=0
rev=0

y=$num
while [[ $num -gt 0 ]]
do
   x=`expr $num % 10`
   temp=`expr $rev \* 10`
   rev=`expr $temp + $x`
   num=`expr $num / 10`
done
echo "Reverse of $y is $rev"
