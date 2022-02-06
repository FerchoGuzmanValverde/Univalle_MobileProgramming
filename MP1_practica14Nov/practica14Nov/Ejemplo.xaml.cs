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
    /// Lógica de interacción para Ejemplo.xaml
    /// </summary>
    public partial class Ejemplo : Window
    {
        public Ejemplo()
        {
            InitializeComponent();
        }

        private void btnregresar_Click(object sender, RoutedEventArgs e)
        {
            Home home1 = new Home();
            this.Close();
            home1.Show();
        }
    }
}
