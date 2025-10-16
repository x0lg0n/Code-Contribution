# Delete Temporary Files Older Than 7 Days

#!/bin/bash
find /tmp -type f -mtime +7 -exec rm -f {} \;
echo "Old temporary files deleted!"
