EJemplos de utilizacion de semaforo binario

Semaphore sem = new Semaphore (1);

sem.acquire(1);
sem.release(1);


//////////////

Ejemplos de utilizacion de semaforo generico

Semaphore sem= new Semaphore(5);

sem.acquire(1);
sem.acquire(3);

sem.release(1);
sem.release(3);