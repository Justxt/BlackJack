import BaseLayout from "../components/BaseLayout";
import Sidebar from "../components/Sidebar";
import RootLayout from "../layout";

export default function Dashboard() {
  return (
    <BaseLayout>
      <div>
        Bienvenido a tu dashboard, aqui podras ver tu informacion y controlar
        tus datos
      </div>
    </BaseLayout>
  );
}
