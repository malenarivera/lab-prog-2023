Introduccion 
Semaforos:
Constan de una cantidad de permisos, pueden utilizarse tanto para exclusion mutua como para
cooperacion y comunicacion. Si utilizamos un semaforo para exclusion mutua tendra un permiso
para que un solo hilo accede a la seccion critica

Para utilizarlo hay que importar la clase Java.Util.Semaphore, luego lo creamos con la cantidad de permisos
que deseamos y lo utilizamos haciendo acquire o release. Si un hilo intenta hacer un release de un semaforo
que no tiene permisos disponibles se quedara bloqueado hasta que se libere algun permiso. 
Semaphore s= new Semaphore(1);
Metodos
s.acquire() o s.acquire(n);
s.release() o s.release(n);
s.tryAcquire() intenta hacer el acquire, si no puede no se queda bloqueado, si puede hace el acquire y devuelve true. 
