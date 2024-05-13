"use client";

import Link from "next/link";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";
import { FaWpforms } from "react-icons/fa";
import { PiPasswordFill } from "react-icons/pi";

export default function Login() {
  const router = useRouter();
  //  aqui se crean los estados para el login
  const [loginCedula, setLoginCedula] = useState("");
  const [loginPassword, setLoginPassword] = useState("");

  //
  const [userData, setUserData] = useState(null); // aqui se crea el estado para el usuario

  //metodo para obtener los detalles de un usuario
  const getLoginDetails = async () => {
    try {
      const response = await fetch("http://localhost:5284/api/Users/login", {
        method: "POST",
        headers: {
          "Content-type": "application/json",
        },
        body: JSON.stringify({
          cedula: loginCedula,
          password: loginPassword,
        }),
      });
  
      if (response.ok) {
        console.log("Usuario logeado correctamente");
        const data = await response.json();
        localStorage.setItem("token", data.token);
        router.push("/dashboard");
      } else {
        const errorMessage = await response.text();
        console.error("Error al loguear usuario:", errorMessage);
      }
    } catch (error) {
      console.error("Error al hacer la solicitud:", error); // Imprime errores de red u otros errores de JavaScript
    }
  };
  


  // Comprobamos si ya existe un token en el localStorage para redirigir al dashboard
  useEffect(() => {
    // aqui se chequea si existe un token en el localstorage
    const token = localStorage.getItem("token");
    if (token) {
      // aqui si existe un token se redirige al dashboard
      router.push("/dashboard");
    }
  }, []);

  return (
    <div className="flex flex-col items-center justify-center min-h-screen py-2 bg-red-500">
      <main className="flex flex-col items-center justify-center w-full flex-1 px-20 text-center">
        <div className="bg-white rounded-2xl shadow-2xl flex w-2/3 max-w-4xl">
          {/* Seccion del login */}
          <div className="w-3/5 p-5">
            <div className="text-left font-bold">
              <span className="text-red-500">BLACK</span>JACK
            </div>
            <div className="py-16">
              <h2 className="text-3xl font-bold text-red-500 mb-2">
                Iniciar Sesion
              </h2>
              <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>
              <div className="flex flex-col items-center">
                {/* Aqui se crea el formulario de login*/}
                <div className="bg-gray-100 w-72 p-2 rounded-3xl flex items-center mt-5 mb-4">
                  <FaWpforms className="text-gray-400 m-2" />
                  <input
                    type="text"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Cedula"
                    value={loginCedula}
                    onChange={(e) => {
                      setLoginCedula(e.target.value);
                    }}
                  />
                </div>

                <div className="bg-gray-100 w-72 p-2 rounded-3xl flex items-center">
                  <PiPasswordFill className="text-gray-400 m-2" />
                  <input
                    type="password"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Contraseña"
                    value={loginPassword}
                    onChange={(e) => {
                      setLoginPassword(e.target.value);
                    }}
                  />
                </div>
                {/* Aqui se crea el boton de login*/}
                <Link
                  href="#"
                  className="border-2 text-red-500 border-red-500 rounded-full px-12 py-2 mt-6 inline-block font-semibold hover:bg-white hover:text-black"
                  onClick={() => {
                    getLoginDetails();
                  }}
                >
                  Entrar
                </Link>
              </div>
            </div>
          </div>
          {/* Seccion del registro */}
          <div className="w-2/5 bg-red-500 text-white rounded-tr-2xl rounded-br-2xl py-36 px-12">
            <h2 className="text-3xl font-bold mb-2">¡HOLA!</h2>
            <div className="border-2 w-10 border-white inline-block mb-2"></div>
            <p className="mb-10">
              ¿Quieres tener tu cuenta y administrar tus tokens del casino?
              ¡Registrate!
            </p>
            <Link
              href="/register"
              className="border-2 border-white rounded-full px-12 py-2 inline-block font-semibold hover:bg-white hover:text-red-500"
            >
              Registrarse
            </Link>
          </div>
        </div>
      </main>
    </div>
  );
}
