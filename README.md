# Progetto Biblioteca
L’obiettivo del progetto è la gestione di una biblioteca. La biblioteca è divisa in una o più stanze. È necessario quindi gestire ogni singola stanza. Una stanza ha un identificativo (una lettera dell’alfabeto). Bisogna garantire che tale identificativo sia univoco. Questi identificativi possono essere generati dal programma, assegnandoli in ordine alfabetico crescente. Una stanza è composta da uno o più scaffali. Uno scaffale può ospitare un numero massimo di libri. È, dunque, caratterizzato da un numero prestabilito di posti. Un posto può essere vuoto, oppure può contenere un solo libro. Bisogna gestire i libri, ovvero permettere l’inserimento, la rimozione e i prestiti di un libro. Un libro può essere in due stati: prestato o disponibile. Il programma deve quindi garantire il corretto passaggio da uno stato all’altro, quando richiesto.
Il programma deve gestire le ricerche di libri nella biblioteca. Le ricerche devono essere effettuate sulla base di un criterio di ricerca. Nel programma vengono implementati due criteri: “stesso titolo” e “stessa stanza”. L’output delle ricerche può essere ordinato secondo un criterio di ordinamento. Nel programma vengono implementati due criteri: “per titolo” e “per collocazione”. 
Il programma deve fornire un’interfaccia grafica. In particolare deve lanciare una prima finestra principale, contenente delle informazioni sulla biblioteca e un piccolo menù che permette all’utente di scegliere l’operazione. Con la pressione del pulsante di salvataggio, devono essere salvati i dati della biblioteca. Con la pressione del pulsante di ricerca, deve essere aperta un’altra finestra, in cui effettuare la ricerca. L’utente può quindi scegliere il criterio di ricerca e il criterio di ordinamento secondo il quale verrà ordinato il risultato della ricerca. La finestra deve mostrare anche una o più caselle di testo in cui inserire le chiavi di ricerca. 
In caso di pressione del pulsante “gestione”, deve essere aperta una nuova finestra, in cui l’utente può scegliere una stanza della biblioteca e un’operazione da effettuare. Una volta confermata la scelta, deve essere aperta una nuova finestra. Nella nuova finestra vengono riportate alcune informazioni sulla stanza. Inoltre deve essere visualizzata una pianta della stanza. Devono essere visualizzati gli scaffali, presenti nella stanza e i posti per ogni scaffale. Ogni posto è rappresentato da un bottone. Il bottone è di colore bianco se il posto è libero, verde se è occupato da un libro disponibile, rosso se è occupato da un libro prestato. L’applicazione deve permettere all’utente di premere uno dei pulsanti, per eseguire l’operazione scelta. In caso di inserimento viene aperta una finestra in cui inserire i dati del nuovo libro. In caso di prestito, restituzione o rimozione di un libro, la casella, corrispondente al posto selezionato, cambia colore. In questi ultimi casi, viene aperta una finestra di conferma, in cui appaiono i dettagli del libro.
L’applicazione, infine, deve gestire due casi di errore: il caso in cui si tenti di inserire un libro in un posto occupato da un altro libro e il caso in cui si tenti di ordinare un output di ricerca vuoto.
