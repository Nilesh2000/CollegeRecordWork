# include <stdio.h>
 struct Complex
 {
  int realPart, imaginaryPart;
 };

 void Menu();
struct Complex readComplex();
void displayComplex(struct Complex c);
struct Complex addComplex(struct Complex c1, struct Complex c2);
struct Complex diffComplex(struct Complex c1, struct Complex c2);
struct Complex multiplyComplex(struct Complex c1, struct Complex c2);
void main()
{
 Menu();
}
void Menu()
{
  int Choice, Flag=0;
  struct Complex x, y, Res;
   while(Choice!=6)
    {
      printf("\nEnter Any One Of The Following Choices:-");
      printf("\n1. Read A Complex Number");
      printf("\n2. Display The Complex Number");
      printf("\n3. Add Two Complex Numbers");
      printf("\n4. Subtract Two Complex Numbers");
      printf("\n5. Multiply Two Complex Numbers");
      printf("\n6. Terminate The Program");
      printf("\nYour Choice Is...");
      scanf("%d", &Choice);
       switch(Choice)
        {
          case 1:Flag=1;
                 Res=readComplex();
                  break;
          case 2:if(Flag==0)
                  printf("\nPlease Enter The Complex Number First.\n");
                 else
                  displayComplex(Res);
                 break;
          case 3:printf("\nComplex Number 1:-");
                 x=readComplex();
                 printf("\nComplex Number 2:-");
                 y=readComplex();
                 Res=addComplex(x,y);
                 displayComplex(Res);
                  break;
          case 4:printf("\nComplex Number 1:-");
                 x=readComplex();
                 printf("\nComplex Number 2:-");
                 y=readComplex();
                 Res=diffComplex(x,y);
                 displayComplex(Res);
                  break;
          case 5:printf("\nComplex Number 1:-");
                 x=readComplex();
                 printf("\nComplex Number 2:-");
                 y=readComplex();
                 Res=multiplyComplex(x,y);
                 displayComplex(Res);
                  break;
          case 6:printf("\nThank You For Using The Program.");
                  break;
          default:printf("\nInvalid Choice.\n");
        }
    }
}
struct Complex readComplex()
{
  struct Complex c;
  printf("\nEnter The Real And Imaginary Part...");
  scanf("%d %d", &c.realPart, &c.imaginaryPart);
  return c;
}
void displayComplex(struct Complex c)
{
  printf("\nThe Result Is...%d+(%di)\n", c.realPart, c.imaginaryPart);
}
struct Complex addComplex(struct Complex c1, struct Complex c2)
{
  struct Complex c;
  c.realPart=c1.realPart+c2.realPart;
  c.imaginaryPart=c1.imaginaryPart+c2.imaginaryPart;
  return c;
}
struct Complex diffComplex(struct Complex c1, struct Complex c2)
{
 struct Complex c;
 c.realPart=c1.realPart-c2.realPart;
 c.imaginaryPart=c1.imaginaryPart-c2.imaginaryPart;
 return c;
}
struct Complex multiplyComplex(struct Complex c1, struct Complex c2)
{
 struct Complex c;
 c.realPart=(c1.realPart*c2.realPart)-(c1.imaginaryPart*c2.imaginaryPart);
 c.imaginaryPart=(c1.realPart*c2.imaginaryPart)+(c1.imaginaryPart*c2.realPart);
 return c;
}
