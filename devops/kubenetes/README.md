# Kubernetes  

## why kubernetes?  

- the unit of deployment is changing from a machine to a container  

- infrastructure has become immutable  

- emphasis on treating the datacenter as a large server (cluster)  

- tools are evolving to manage the new datacenter infrastructure  

- manage the lifecycle of containerised applications running in production  

- automate the distribution of applications  

- ensure high levels of utilisation and efficiency

## terminology  

### cluster  

* master  
	* coordinate the cluster  
		* schedule applications  
		* maintain applications’ desired state  
		* scaling applications  
		* roll out new updates  
* node  
	* worker that run applications  
	* kubelet  
		* an agent for managing the node and communicating with the Kubernetes master  
		* manages the pods and the containers running on a machine  
	* pod  
		* a kubernetes abstraction that represents a group of one or more application containers, and some shared resources for those containers  
* service  
	* an abstraction which defines a logical set of Pods and a policy by which to access them  
	* ServiceSpec  
		* ClusterIP  
			* expose the service on an internal IP in the cluster  
			* the service only reachable from within the cluster  
		* NodePort  
			* expose the service on the same port of each selected Node in the cluster using NAT  
			* the service is accessible from outside the cluster using `:`  
		* LoadBalancer  
			* create an external load balancer in the current cloud and assigns a fixed external IP to the service  
		* ExternalName  
			* expose the service using an arbitrary name by returning a CNAME record with the name  
	* label / selector  
		* key/value pairs attached to objects  
			* designate objects for development, test, and production  
			* embed version tags  
			* classify an object using tags  

### deployment  

* scaling  
	* change the number of replicas in a deployment  

## Architecture  

### master  

### node  

### pod  

* group of one or more containers that are always co-located, co-scheduled, and run in a shared context.  
* containers in the same pod have the same hostname  
* each pod is isolated by  
	* process ID namespace  
	* network namespace  
	* interprocess communication namespace  
	* unix time sharing namespace  
* alternative to a vm with multiple processes  
* fundamental unit of deployment in kubernetes  

### labels & selectors  

* key/value pairs associated with kubernetes objects  
* used to organise and select subsets of objects  
* attached to objects at creation time but modified at any time  
* labels are the essential glue to associate one api object with other  
	* replication controller -> pods  
	* service -> pods  
	* pods -> nodes  

### services  

* an abstraction to define a logical set of pods bound by a policy by to access them  
* services are exposed through internal and external endpoints  
* services can also point to non-kubernetes endpoints through a virtual-ip-bridge  
* supports tcp and udp  
* interfaces with kibe-proxy to manipulate iptables  
* service can be exposed internal or external to the cluster  

### replication controller  

* ensures that a pod or homogeneous set of pods are always up and available  
* always maintains desired number of pods  
* creating a replication controller with a count of 1 ensures that a pod is always available  
* replication controller and pods are associated through labels  

### replica set  

* replica sets are the next generation replication controllers  
* ensures specified number of pods are always running  
* pods are replaced by replica sets when a failure occurs  
	* new pods are automatically scheduled  
* labels and selectors are used for associating pods with replica sets  
* usually combined with pods when defining deployment  

## tools  

### minikube  

* a CLI tool that provisions and manages single-node kubenetes clusters optimized for development workflows.  

### kubectl  
