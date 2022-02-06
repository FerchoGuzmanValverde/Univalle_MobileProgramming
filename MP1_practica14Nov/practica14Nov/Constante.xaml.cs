using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace practica14Nov
{
    /// <summary>
    /// Lógica de interacción para Constante.xaml
    /// </summary>
    public partial class Constante : Window
    {
        public Constante()
        {
            InitializeComponent();
        }

        private void btnregresar_Click(object sender, RoutedEventArgs e)
        {
            Home home3 = new Home();
            this.Close();
            home3.Show();
        }

        private void btniniciar_Click(object sender, RoutedEventArgs e)
        {
            int contador = 0;

            int numero, res, aux, max2, max3, max4, maximo, minimo, ctr, u = 0, d = 0, c = 0, m = 0, max1 = 0;

            string numeroIngresado = Box1.Text;
            try
            {
                if (numeroIngresado != null)
                {

                    numero = int.Parse(numeroIngresado);

                    if (numero > 999 && numero <= 9999)
                    {
                        do
                        {
                            res = 0;
                            ctr = 0;

                            aux = 0;
                            u = 0;
                            d = 0;
                            c = 0;
                            m = 0;
                            contador = contador + 1;
                            while (numero > 10) //ordenar numeros
                            {
                                res = numero % 10;
                                switch (aux)
                                {
                                    case 0:
                                        {
                                            u = res;
                                            aux++;
                                            break;
                                        }
                                    case 1:
                                        {
                                            d = res;
                                            aux++;
                                            break;
                                        }
                                    case 2:
                                        {
                                            c = res;
                                            aux++;
                                            break;
                                        }
                                }
                                numero /= 10;

                            }
                            m = numero;
                            max1 = u;
                            max2 = d;
                            max3 = c;
                            max4 = m;


                            if (max1 != max2 || max2 != max3 || max3 != max4)
                            {
                                int k = 0;
                                do
                                {
                                    if (max1 <= max2)
                                    {
                                        aux = max1;
                                        max1 = max2;
                                        max2 = aux;
                                    }
                                    if (max1 >= max2 && max2 <= max3)
                                    {
                                        aux = max2;
                                        max2 = max3;
                                        max3 = aux;
                                    }
                                    if (max1 >= max2 && max2 >= max3 && max3 <= max4)
                                    {
                                        aux = max3;
                                        max3 = max4;
                                        max4 = aux;
                                    }
                                    k++;

                                } while (k <= 3);

                                maximo = max1 * 1000 + max2 * 100 + max3 * 10 + max4;
                                minimo = max4 * 1000 + max3 * 100 + max2 * 10 + max1;

                                lvoperaciones.Items.Add((maximo + " - " + minimo + " = " + (maximo - minimo)) + "\n");
                                lbliteraciones.Content = contador;
                                ctr++;
                                numero = maximo - minimo;
                                if (numero == 6174)
                                {
                                    ctr = 9;
                                }
                            }
                            else
                            {
                                MessageBox.Show("Error: Los números son iguales");
                                ctr = 9;
                            }
                        } while (ctr <= 7);
                    }
                    else
                    {
                        MessageBox.Show("Error: El número no es de 4 digitos");
                    }
                }
            }
            catch (Exception)
            {

                MessageBox.Show("Error: Ingrese solo números");
            }


        }

        private void btnlimpiar_Click(object sender, RoutedEventArgs e)
        {
            lvoperaciones.Items.Clear();
            lbliteraciones.Content = "";
            Box1.Clear();
        }
    }
}
