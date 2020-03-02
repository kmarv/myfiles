FILE=C:/Users/spike/OneDrive/Desktop/admin/status.sh
if test -f "$FILE"; then
    echo "$FILE exists"
else
    echo "file not found"
fi