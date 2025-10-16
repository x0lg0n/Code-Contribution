#!/bin/bash
echo "Memory Usage:"
free -h
echo "Top 5 Memory Consuming Processes:"
ps aux --sort=-%mem | head -n 6
echo "Disk Usage:"
df -h
echo "Top 5 Disk Space Consuming Directories:"
du -sh * | sort -rh | head -n 5 
echo "I/O Statistics:"
iostat -x 1 2
echo "Network Traffic:"
netstat -tulpn | grep LISTEN
echo "CPU Load Average:"
uptime
echo "System Uptime:"
uptime -p
echo "Current Date and Time:"
date +"%Y-%m-%d %H:%M:%S"
echo "Kernel Version:"
uname -r
echo "Hostname:"
hostname
echo "List of Running Services (systemctl):"
systemctl list-units --type=service --state=running
echo "List of Installed Packages (dpkg):"
dpkg --get-selections
echo "List of Open Ports:"
ss -lntu
echo "List of Users Currently Logged In:"
whoami
echo "Last Boot Time:"
last reboot | head -n 1
echo "Total RAM Available:"
grep MemAvailable /proc/meminfo
echo "Swap Space Information:"
swapon --show
echo "File System Mount Points:"
mount | column -t
echo "List of Scheduled Cron Jobs:"
crontab -l
echo "List of Network Interfaces:"
ip addr show
echo "List of Active TCP Connections:"
netstat -anp | grep tcp
echo "List of Active UDP Connections:"
netstat -anp | grep udp
echo "List of Recently Modified Files in Current Directory:"
ls -ltr ./*
echo "List of Recently Accessed Directories:"
find . -maxdepth 1 -mindepth 1 -type d -printf "%T@ %p\n" | sort -nr | head -n 5 | cut -d' ' -f2-