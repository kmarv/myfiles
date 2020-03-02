# Sorting the array in Bash  
# using Bubble sort 
  
# Static input of Array 
echo "first number"
read num1
echo "second number"
read num2
echo "third number"
read num3
echo "forth number"
read num4
echo "fifth number"
read num5

arr[0]=$num1
arr[1]=$num2
arr[2]=$num3
arr[3]=$num4
arr[4]=$num5 
  
echo "Array in original order"
echo ${arr[*]} 
  
# Performing Bubble sort  
for ((i=0; i<5; i++)) 
do      
    for((j=i; j<5-i-1; j++)) 
    do      
        if ((${arr[j]} > ${arr[$((j+1))]})) 
        then
            # swap 
            temp=${arr[$j]} 
            arr[$j]=${arr[$((j+1))]}   
            arr[$((j+1))]=$temp 
        fi
    done
done
  
echo "Array in sorted order :"
echo ${arr[*]}