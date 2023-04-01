import java.io.*;
public class Proyecto {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int Opc, n = 0;
        int IDlibro[] = new int[50];
        String NombreLibro[] = new String[50];
        String Autor[] = new String[50];
        int Cantidad[] = new int[50];
        String Alumno[] = new String[50];
        int NP[] = new int[50];
        //String LP[] = new String[50];
        int IDE[] = new int[50];
        String NLP[][] = new String[50][50];
        do {
            Opc = Menu();
            switch (Opc) {
                case 1:
                    if (n == 0) {
                        n = Leer();
                        Ingresar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    } else {
                        System.out.println("Datos ya registrados");
                    }
                    break;
                case 2:
                    if (n == 0) {
                        System.out.println("No hay datos por reportar");
                    } else {
                        Reportar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 3:
                    if (n == 0) {
                        n = Leer();
                        Ingresar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    } else {
                        n = Agregar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 4:
                    if (n == 0) {
                        System.out.println("No hay datos por modificar");
                    } else {
                        Modificar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 5:
                    if (n == 0) {
                        System.out.println("No hay datos por eliminar");
                    } else {
                        n = Eliminar(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 6:
                    if (n == 0) {
                        System.out.println("No hay datos para consultar por nombre");
                    } else {
                        ConsultarNombre(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 7:
                    if (n == 0) {
                        System.out.println("No hay datos por consultar por ID");
                    } else {
                        ConsultarID(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 8:
                    if (n == 0) {
                        System.out.println("No hay datos por ordenar");
                    } else {
                        Ascendente(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 9:
                    if (n == 0) {
                        System.out.println("No hay datos por ordenar");
                    } else {
                        Descendente(IDlibro, NombreLibro, Autor, Cantidad, n);
                    }
                    break;
                case 10:
                    if (n == 0) {
                        System.out.println("No se han ingresado datos para esta opción");
                    } else {
                        Prestamo(Alumno, IDE, NP, IDlibro, NLP, NombreLibro, Cantidad, n
                        );
                    }
                    break;
                case 11:
                    if (n == 0) {
                        System.out.println("No se han ingresado datos para esta opción");
                    } else {
                        ConsultaPrestamo(IDlibro, Alumno, IDE, NLP, NombreLibro, NP, Cantidad, n);
                    }
                    break;
                case 12:
                    FIN();
                    break;
            }
        } while (Opc != 12);
    }
    static int Menu() throws IOException {
        int opc;
        do {
            System.out.println("\nMENÚ DE OPCIONES: ");
            System.out.println("1.- ingrese la cantidad de datos para el catalogo de la biblioteca ");
            System.out.println("2.- Reportar todos los datos de los libros de la biblioteca ");
            System.out.println("3.- Agregar datos al catálogo de la biblioteca ");
            System.out.println("4.- Modificar datos del catálogo de la biblioteca ");
            System.out.println("5.- Eliminar datos del catálogo de la biblioteca ");
            System.out.println("6.- Consultar por nombre de libro en catálogo de la biblioteca ");
            System.out.println("7.- Consultar por ID de libro en catálogo de la biblioteca ");
            System.out.println("8.- Ordenar los datos alfabéticamente en forma ascendente por nombre de libro ");
            System.out.println("9.- Ordenar los datos en forma descendente en base al ID de los libros ");
            System.out.println("10.- proceso de préstamo de libros en la biblioteca ");
            System.out.println("11.- Consultar si un Usuario determinado tiene libros prestados ");
            System.out.println("12.- Fin de la operacion ");
            System.out.println("Escoger ejercicio: ");
            opc = Integer.parseInt(br.readLine());
        } while (opc < 1 || opc > 12);
        return opc;
    }
    static int Leer() throws IOException {
        int N;
        do {
            System.out.println("Ingresar N° de datos");
            N = Integer.parseInt(br.readLine());
        } while (N <= 0 || N > 50);
        return N;
    }
    static void Ingresar(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[], int n)throws IOException{
        int i;
        for(i=0; i<n; i++){
            do{
                System.out.println(" ingresar ID del libro["+i+"]: ");
                IDlibro[i]=Integer.parseInt(br.readLine());
            }while(IDlibro[i]<=1000);

            System.out.println(" ingresar nombre del libro["+i+"]: ");
            NombreLibro[i]=br.readLine();

            System.out.println(" ingresar Autor del libro["+i+"]: ");
            Autor[i]=br.readLine();

            do{
                System.out.println(" ingresar cantidad de libros["+i+"]: ");
                Cantidad[i]=Integer.parseInt(br.readLine());
            }while(Cantidad[i]<=0);
        }
        return;
    }
    static void Reportar(int IDlibro[],String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i;
        System.out.println("Reporte de datos de los libros de la biblioteca: ");
        for(i=0; i<n; i++){
            System.out.println(IDlibro[i]+"\t"+NombreLibro[i]+"\t"+Autor[i]+"\t"+Cantidad[i]);
        }
        return;
    }
    static int Agregar(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        if(n<50){
            do{
                System.out.println(" Agregar ID del libro["+n+"]: ");
                IDlibro[n]=Integer.parseInt(br.readLine());
            }while(IDlibro[n]<=1000);

            System.out.println(" Agregar nombre del libro["+n+"]: ");
            NombreLibro[n]=br.readLine();

            System.out.println(" Agregar Autor del libro["+n+"]: ");
            Autor[n]=br.readLine();

            do{
                System.out.println(" Agregar cantidad de libros["+n+"]: ");
                Cantidad[n]=Integer.parseInt(br.readLine());
            }while(Cantidad[n]<=0);
            n=n+1;
        }
        else{
            System.out.println("Datos llenos no es posible agregar mas");
        }
        return n;
    }
    static void Modificar(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[], int n)throws IOException{
        int i,pos=-1;
        String nomaux;

        System.out.println(" ingrese dato a buscar ");
        nomaux=br.readLine();
        for(i=0; i<n; i++){
            if(NombreLibro[i].compareTo(nomaux)==0 || Autor[i].compareTo(nomaux)==0){
                pos=i;
                i=n;
            }
        }
        if(pos==-1){
            System.out.println("Datos buscados no existen");
        }
        else{
            System.out.println("Datos encontrados");
            System.out.println("Ingrese nuevos datos");
            do{
                System.out.println(" Modificar ID del libro["+pos+"]: ");
                IDlibro[pos]=Integer.parseInt(br.readLine());
            }while(IDlibro[pos]<=1000);

            System.out.println(" Modificar nombre del libro["+pos+"]: ");
            NombreLibro[pos]=br.readLine();

            System.out.println(" Modificar Autor del libro["+pos+"]: ");
            Autor[pos]=br.readLine();

            do{
                System.out.println(" Modificar cantidad de libros["+pos+"]: ");
                Cantidad[pos]=Integer.parseInt(br.readLine());
            }while(Cantidad[pos]<=0);
        }
        return;
    }
    static int Eliminar(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i,pos=-1;
        String nomaux;
        System.out.println(" ingrese dato a buscar ");
        nomaux=br.readLine();
        for(i=0; i<n; i++){
            if(NombreLibro[i].compareTo(nomaux)==0 || Autor[i].compareTo(nomaux)==0){
                pos=i;
                i=n;
            }
        }
        if(pos==-1){
            System.out.println("Datos buscados no existen");
        }
        else{
            IDlibro[pos]=IDlibro[n-1];
            NombreLibro[pos]=NombreLibro[n-1];
            Autor[pos]=Autor[n-1];
            Cantidad[pos]=Cantidad[n-1];
            n=n-1;
        }
        return n;
    }
    static void ConsultarNombre(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i,pos=-1;
        String nomaux;

        System.out.println(" ingrese nombre del libro a buscar ");
        nomaux=br.readLine();

        for(i=0; i<n; i++){
            if(NombreLibro[i].compareTo(nomaux)==0){
                pos=i;
                i=n;
            }
        }
        if(pos==-1){
            System.out.println("Datos buscados no existen");
        }
        else{
            System.out.println("Nombre del libro encontrado");
            System.out.println(NombreLibro[pos]+"\t"+IDlibro[pos]+"\t"+Autor[pos]+"\t"+Cantidad[pos]);
        }
        return;
    }
    static void ConsultarID(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i,pos=-1;
        int nomaux;

        System.out.println(" ingrese ID del libro a buscar ");
        nomaux=Integer.parseInt(br.readLine());

        for(i=0; i<n; i++){
            if(IDlibro[i]==nomaux){
                pos=i;
                i=n;
            }
        }
        if(pos==-1){
            System.out.println("Datos buscados no existen");
        }
        else{
            System.out.println("Nombre del libro encontrado");
            System.out.println(IDlibro[pos]+"\t"+NombreLibro[pos]+"\t"+Autor[pos]+"\t"+Cantidad[pos]);
        }
        return;
    }
    static void Ascendente(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i,j;
        String nomaux="";
        int ID;
        String autor;
        int cant;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(NombreLibro[i].compareTo(NombreLibro[j])>0){
                    nomaux=NombreLibro[i];
                    NombreLibro[i]=NombreLibro[j];
                    NombreLibro[j]=nomaux;
                    ID=IDlibro[i];
                    IDlibro[i]=IDlibro[j];
                    IDlibro[j]=ID;
                    autor=Autor[i];
                    Autor[i]=Autor[j];
                    Autor[j]=autor;
                    cant=Cantidad[i];
                    Cantidad[i]=Cantidad[j];
                    Cantidad[j]=cant;
                }
            }
        }
        return;
    }
    static void Descendente(int IDlibro[], String NombreLibro[], String Autor[], int Cantidad[],int n)throws IOException{
        int i,j;
        String nomaux="";
        int ID;
        String autor;
        int cant;
        for(i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                if(NombreLibro[i].compareTo(NombreLibro[j])<0){
                    nomaux=NombreLibro[i];
                    NombreLibro[i]=NombreLibro[j];
                    NombreLibro[j]=nomaux;
                    ID=IDlibro[i];
                    IDlibro[i]=IDlibro[j];
                    IDlibro[j]=ID;
                    autor=Autor[i];
                    Autor[i]=Autor[j];
                    Autor[j]=autor;
                    cant=Cantidad[i];
                    Cantidad[i]=Cantidad[j];
                    Cantidad[j]=cant;
                }
            }
        }
        return;
    }
    static void Prestamo(String Alumno[],int IDE[], int NP[], int IDlibro[], String NLP[][], String NombreLibro[], int Cantidad[], int n)throws IOException{
        int c,i,v,pos=-1,idaux;
        char res;
        for(c=0;c<=49;c++){
            System.out.print("Ingrese su nombre para registro de Prestamo: ");
            Alumno[c]= br.readLine().toUpperCase();

            do{
                System.out.print("Ingrese su ID de estudiantes: ");
                IDE[c]= Integer.parseInt(br.readLine());
            }while(IDE [c]<1000||IDE[c]>=10000);

            do{
                System.out.print("Cuantos libros va a retirar: ");
                NP[c]= Integer.parseInt(br.readLine());
            }while(NP[c]<=0);
            for(i=0;i<NP[c];i++){
                System.out.println("");
                do{
                    System.out.println("Ingrese el ID del libro N°"+(i+1));
                    idaux= Integer.parseInt(br.readLine());
                }while(idaux<1000||idaux>=10000);
                for(v=0;v<n;v++){
                    if(IDlibro[v]==idaux){
                        pos=v;
                        v=n;
                    }
                }
                if(pos==-1){System.out.print("El libro no se encuentra: ");
                }
                else{
                    NLP[c][i]=NombreLibro[pos];
                    System.out.println("Libro encontrado: "+NombreLibro[pos]);
                    Cantidad[pos]=Cantidad[pos]-1;
                    System.out.println("Reduciendo...");
                }
            }
            System.out.println("Desea registrar otro prestamo(Ingrese SI o NO)");
            do{
                res= br.readLine().toUpperCase().charAt(0);
            }while(res=='S' && res=='N');
            if(res=='N'){
                c=50;
            }
        }
        return;
    }
    static void ConsultaPrestamo(int IDlibro[], String Alumno[], int IDE[], String NLP[][], String NombreLibro[], int NP[], int Cantidad[], int n)throws IOException{
        int i,pos=-1;
        String nomaux;
        System.out.print("ingrese el nombre a consultar: ");
        nomaux=br.readLine();
        for(i=0;i<n;i++){
            if(Alumno[i].compareTo(nomaux)==0){
                pos=i;
                i=n;
            }
        }
        if(pos==-1){
            System.out.println("Dato Buscado no existe");
        }
        else{
            System.out.println("Dato enocntrado");
            System.out.println(+NP[pos]+"\t"+Alumno[pos]+"\t"+NLP[pos]+"\t"+IDE[pos]);
        }
        return;
    }
    static void FIN() throws IOException {
        System.out.println("\nproblemas resueltos, ¡vuelva pronto!.");
        return;
    }
}