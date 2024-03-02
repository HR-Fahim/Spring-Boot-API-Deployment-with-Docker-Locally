1.docker ps

kubectl config get-contexts

kubectl config use-context docker-desktop

kubectl cnfig use-context docker-desktop

2.kubectl create deployment kbe-rest --image springframeworkguru/kbe-rest-brewery --dry-run=client -o=yaml > deployment.yml 

ls

notepad deployment.yml

kubectl apply -f deployment.yml

kubectl get all

docker ps

3.kubectl create service clusterip kbe-rest --tcp=8080:8080 --dry-run=client -o=yaml >> service.yml

ls

kubectl apply -f service.yml

kubectl get all

kubectl create service clusterip kbe-rest --tcp=8080:8080 --dry-run=client -o=yaml >> service.yml (check purpose)

notepad service.yml

4.ipconfig /all 

kubectl port-forward service/kbe-rest 8080:8080 (by running)

curl localhost:8080/actuator/health (on another terminal)
