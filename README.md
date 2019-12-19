# README
This contains the steps to deploy this application on docker and execute it on a test dataset which is available at 
http://data.insideairbnb.com/singapore/sg/singapore/2019-08-28/visualisations/listings.csv


## Build the project
```
cd /Documents/projects/
git clone https://github.com/nvsajeeva/bdpcoursework.git
cd bdpcoursework
git checkout develop
mvn clean install
```
## Copy the dataset
```
cd /Documents/projects/
mkdir listings
wget -c http://data.insideairbnb.com/singapore/sg/singapore/2019-08-28/visualisations/listings.csv .
```
## Start the docker container
```
docker pull suhothayan/hadoop-hive-pig:2.7.1
docker run -p 8088:8088 -p 50070:50070 --name hadoop-hive-pig -v /Documents/projects:/resource -d suhothayan/hadoop-hive-pig:2.7.1
```

```
docker ps
ONTAINER ID        IMAGE                              COMMAND                  CREATED             STATUS              PORTS                                                                                                                                                             NAMES
76556cf018df        suhothayan/hadoop-hive-pig:2.7.1   "/etc/bootstrap.sh -d"   37 seconds ago      Up 36 seconds       2122/tcp, 8030-8033/tcp, 8040/tcp, 8042/tcp, 19888/tcp, 49707/tcp, 50010/tcp, 0.0.0.0:8088->8088/tcp, 50020/tcp, 50075/tcp, 50090/tcp, 0.0.0.0:50070->50070/tcp   hadoop-hive-pig
```
## Login to the container and verify the files

```
docker exec -it 76556cf018df /bin/bash
cd resource/listings
ls -ltr

-rw-r--r-- 1 root root 1164675 Dec 18 21:53 listings.csv

```
