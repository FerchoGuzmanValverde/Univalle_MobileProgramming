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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace practica14Nov
{
    /// <summary>
    /// Lógica de interacción para MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        string contraseniaOk = "admin", usuarioOk = "admin";
        public MainWindow()
        {
            InitializeComponent();
        }

        private void btningresar_Click(object sender, RoutedEventArgs e)
        {
            string contrasenia, usuario;


            try
            {
                usuario = txbusuario.Text;
                contrasenia = ptxbContrasenia.Password;

                if ((contrasenia == contraseniaOk) && (usuario == usuarioOk))
                {
                    //MessageBox.Show("Datos Correctos");
                    //Abrir ventana wpf

                    Home home = new Home();
                    this.Close();
                    home.Show();

                }
                else
                {
                    MessageBox.Show("Error Al Iniciar Sesion");
                }

            }
            catch (Exception)
            {

                throw;
            }
        }
    }
}
