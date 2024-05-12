"use client";

import Link from "next/link";
import { PiPasswordFill } from "react-icons/pi";
import { FaUser, FaWpforms, FaPhoneAlt } from "react-icons/fa";
import { MdEmail } from "react-icons/md";
import { useEffect, useState } from "react";
import { useRouter } from "next/navigation";

export default function Register() {
  const router = useRouter();
  // aqui se crean los estados para el registro
  const [id, setId] = useState("0");
  const [cedula, setCedula] = useState("");
  const [name, setName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [phone, setPhone] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");

  const registerUser = async () => {
    // aqui se hace la peticion al backend para registrarse
    try {
      const response = await fetch("http://localhost:5284/apiUsers/register", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          // aqui se envian los datos del registro al backend
          id: id,
          cedula: cedula,
          name: name,
          lastName: lastName,
          email: email,
          phone: phone,
          password: password,
          confirmPassword: confirmPassword,
        }),
      });

      if (response.ok) {
        console.log("Usuario registrado correctamente");
        console.warn(await response.json()); //aqui obtenemos la respuesta del backend
      } else {
        const errorMessage = await response.text(); //aqui obtenemos el mensaje de error - se sabe que esto es una mala practica pero estabamos probando jeje
        console.error("Error al registrar usuario: ", errorMessage); //aqui se muestra el mensaje de error sobre cual fue el error
      }
    } catch (error) {
      console.error("Error al hacer la solicitud:", error);
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
            <div className="py-10">
              <h2 className="text-3xl font-bold text-red-500 mb-2">
                Registrarse
              </h2>
              <div className="border-2 w-10 border-red-500 inline-block mb-2"></div>

              <div className="flex flex-col items-center">
                <input
                  type="hidden"
                  value={id}
                  onChange={(e) => {
                    setId(e.target.value);
                  }}
                />

                <div className="bg-gray-100 w-96 p-2 rounded-3xl flex items-center mt-5 mb-4">
                  <FaWpforms className="text-gray-400 m-2" />
                  <input
                    type="text"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Cedula"
                    value={cedula}
                    onChange={(e) => {
                      setCedula(e.target.value);
                    }}
                  />
                </div>

                <div className="flex justify-between mb-4">
                  <div className="bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                    <FaUser className="text-gray-400 m-2" />
                    <input
                      type="text"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="Nombre"
                      value={name}
                      onChange={(e) => {
                        setName(e.target.value);
                      }}
                    />
                  </div>
                  <div className="bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                    <FaUser className="text-gray-400 m-2" />
                    <input
                      type="text"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="Apellido"
                      value={lastName}
                      onChange={(e) => {
                        setLastName(e.target.value);
                      }}
                    />
                  </div>
                </div>

                <div className="bg-gray-100 w-96 p-2 rounded-3xl flex items-center mb-4">
                  <MdEmail className="text-gray-400 m-2" />
                  <input
                    type="email"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Correo"
                    value={email}
                    onChange={(e) => {
                      setEmail(e.target.value);
                    }}
                  />
                </div>

                <div className="bg-gray-100 w-96 p-2 rounded-3xl flex items-center mb-4">
                  <FaPhoneAlt className="text-gray-400 m-2" />
                  <input
                    type="number"
                    className="bg-gray-100 outline-none flex-1"
                    placeholder="Telefono"
                    value={phone}
                    onChange={(e) => {
                      setPhone(e.target.value);
                    }}
                  />
                </div>

                <div className="flex justify-between mb-4">
                  <div className="bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                    <PiPasswordFill className="text-gray-400 m-2" />
                    <input
                      type="password"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="Contraseña"
                      value={password}
                      onChange={(e) => {
                        setPassword(e.target.value);
                      }}
                    />
                  </div>
                  <div className="bg-gray-100 w-48 p-2 rounded-3xl flex items-center">
                    <PiPasswordFill className="text-gray-400 m-2" />
                    <input
                      type="password"
                      className="bg-gray-100 outline-none w-full"
                      placeholder="Conf Contraseña"
                      value={confirmPassword}
                      onChange={(e) => {
                        setConfirmPassword(e.target.value);
                      }}
                    />
                  </div>
                </div>

                <Link
                  href="#"
                  className="border-2 text-red-500 border-red-500 rounded-full px-12 py-2 mt-6 inline-block font-semibold hover:bg-white hover:text-black"
                  onClick={() => {
                    registerUser();
                  }}
                >
                  Registrarse
                </Link>
              </div>
            </div>
          </div>
          {/* Seccion de Iniciar Sesion */}
          <div className="w-2/5 bg-red-500 text-white rounded-tr-2xl rounded-br-2xl py-60 px-12">
            <h2 className="text-3xl font-bold mb-2">¡HOLA!</h2>
            <div className="border-2 w-10 border-white inline-block mb-2"></div>
            <p className="mb-5">¿Ya tienes una cuenta?</p>
            <Link
              href="/login"
              className="border-2 border-white rounded-full px-12 py-2 inline-block font-semibold hover:bg-white hover:text-red-500"
            >
              Iniciar Sesion
            </Link>
          </div>
        </div>
      </main>
    </div>
  );
}
