import BaseLayout from "../components/BaseLayout";
import { PiPasswordFill } from "react-icons/pi";
import { FaUser, FaWpforms, FaPhoneAlt } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import Link from "next/link";

export default function Account() {
  return (
    <BaseLayout>
        <main className="flex flex-col items-center justify-center px-20 text-center">
          <div className="bg-gray-100 rounded-2xl shadow-2xl flex w-screen max-w-4xl justify-center">
            {/* Seccion del login */}
            <div className="w-96 p-10">
              <div className="font-bold mb-2">
                <span className="text-red-500">BLACK</span>JACK
              </div>
              <h2 className="text-3xl font-bold text-red-500 mb-2">
                Tus Datos
              </h2>
              <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>
              <div className="py-10">
                <div className="flex flex-col items-center">
                  <div className="border-2 bg-gray-100 w-96 p-2 rounded-3xl flex items-center mt-5 mb-4">
                    <FaWpforms className="text-gray-400 m-2" />
                    <input
                      type="text"
                      className="bg-gray-100 outline-none flex-1"
                      placeholder="1725564578"
                    />
                  </div>

                  <div className="flex justify-between mb-4 space-x-2">
                    <div className="border-2 bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                      <FaUser className="text-gray-400 m-2" />
                      <input
                        type="text"
                        className="bg-gray-100 outline-none w-full"
                        placeholder="Nombre"
                      />
                    </div>
                    <div className="border-2 bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                      <FaUser className="text-gray-400 m-2" />
                      <input
                        type="text"
                        className="bg-gray-100 outline-none w-full"
                        placeholder="Apellido"
                      />
                    </div>
                  </div>

                  <div className="border-2 bg-gray-100 w-96 p-2 rounded-3xl flex items-center mb-4">
                    <MdEmail className="text-gray-400 m-2" />
                    <input
                      type="email"
                      className="bg-gray-100 outline-none flex-1"
                      placeholder="Correo"
                    />
                  </div>

                  <div className="border-2 bg-gray-100 w-96 p-2 rounded-3xl flex items-center mb-4">
                    <FaPhoneAlt className="text-gray-400 m-2" />
                    <input
                      type="number"
                      className="bg-gray-100 outline-none flex-1"
                      placeholder="Telefono"
                    />
                  </div>
                  <Link
                    href="#"
                    className="border-2 text-red-500 border-red-500 rounded-full px-12 py-2 mt-6 inline-block font-semibold hover:bg-white hover:text-black"
                  >
                    Actualizar
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </main>
    </BaseLayout>
  );
}
