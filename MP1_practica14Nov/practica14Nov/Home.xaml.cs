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
    /// Lógica de interacción para Home.xaml
    /// </summary>
    public partial class Home : Window
    {
        public Home()
        {
            InitializeComponent();
        }

        private void btnEjemplo_Click(object sender, RoutedEventArgs e)
        {
            Ejemplo ejemplo = new Ejemplo();
            this.Close();
            ejemplo.Show();
        }

        private void btncalcular_Click(object sender, RoutedEventArgs e)
        {
            Constante constantante = new Constante();
            this.Close();
            constantante.Show();
        }
    }
}
